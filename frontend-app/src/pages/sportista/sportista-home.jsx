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

            <button onClick={handleLogout}>
                Logout
            </button>
        </div>
    );
}

export default SportistaHome;