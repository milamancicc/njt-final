import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

function SportistaHome(){

    const [vezbe, setVezbe] = useState([]);
    const navigate = useNavigate();

    const sportista = JSON.parse(
        localStorage.getItem("sportista")
    );


    function handleLogout(){
        localStorage.removeItem("sportista");
        localStorage.removeItem("token");
        navigate("/sportista-login");
    }

    useEffect(() => {
        const token = localStorage.getItem("token");
        fetch(
            `http://localhost:8080/Projekat/api/sportista-vezbe/${sportista.korisnickoIme}`,
            {
                headers:{
                    "Authorization": "Bearer " + token
                }
            }
        )
        .then(response => response.json())
        .then(data => {
            setVezbe(data);
        });

    }, []);

    function generisiIzvestaj(){

        fetch(
            `http://localhost:8080/Projekat/api/izvestaj/${sportista.korisnickoIme}`
        )
        .then(response => {

            if(!response.ok){
                throw new Error("Greška pri generisanju izveštaja");
            }

            return response.blob();

        })
        .then(blob => {

            const url = window.URL.createObjectURL(blob);

            const link = document.createElement("a");

            link.href = url;
            link.download = "izvestaj.pdf";

            document.body.appendChild(link);

            link.click();

            link.remove();

        })
        .catch(() => {
            alert("Greška pri generisanju izveštaja.");
        });

    }

    return(
        <div>
            <h1>
                Dobrodošao {sportista.ime} {sportista.prezime}
            </h1>
            <p>Moj trener: {sportista.trenerId}</p>
             
            <h2>Moje vezbe</h2>
            {
                vezbe.length === 0 ? (
                    <p>Nema dodeljenih vežbi.</p>
                ) : (
                    <table border="1">
                        <thead>
                            <tr>
                                <th>Naziv vežbe</th>
                                <th>Norma</th>
                                <th>Ponavljanja</th>
                            </tr>
                        </thead>

                        <tbody>
                            {
                                vezbe.map((v, index) => (
                                    <tr key={index}>
                                        <td>{v.vezbaId}</td>
                                        <td>{v.norma}</td>
                                        <td>{v.brojPonavljanja}</td>
                                    </tr>
                                ))
                            }
                        </tbody>
                    </table>
                )
            }

            <button onClick={generisiIzvestaj}>
                Preuzmi izveštaj
            </button>

            <br/><br/>

            <button onClick={handleLogout}>
                Logout
            </button>
        </div>
    );
}

export default SportistaHome;