import {useEffect, useState} from "react";
import { useNavigate } from "react-router-dom";
import TrenerMeni from "../../components/TrenerMeni";

function TrenerHome(){

    const navigate = useNavigate();
    const [sportisti, setSportisti] = useState([]);

    const trener = JSON.parse(
        localStorage.getItem("trener")
    );


    useEffect(()=>{

        ucitajSportiste();

    },[]);

    function prikaziVezbe(id){

        navigate(`/sportista-vezbe/${id}`);

    }

    function ucitajSportiste(){

        fetch(
            `http://localhost:8080/Projekat/api/sportisti/trener/${trener.korisnickoIme}`
        )
        .then(response => response.json())
        .then(data => {
            setSportisti(data);
        });
    }

    function obrisiSportistu(korisnickoIme){

        if(!window.confirm("Da li ste sigurni da želite da obrišete sportistu?")){
            return;
        }


        fetch(
            `http://localhost:8080/Projekat/api/sportisti/${korisnickoIme}`,
            {
                method:"DELETE"
            }
        )
        .then(response=>{

            if(response.ok){


                ucitajSportiste();

            }
            else{
                alert("Greška pri brisanju");
            }

        });

    }


    function generisiIzvestaj(id){

        fetch(
            `http://localhost:8080/Projekat/api/izvestaj/${id}`
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
        .catch(error => {
            alert(error.message);
        });

    }

    return(
        <div>
            <TrenerMeni />
            <h1>
                Dobrodošao {trener.ime} {trener.prezime}
            </h1>

            <h2>Moji sportisti</h2>


            {
                sportisti.length===0 ?

                <p>Nema sportista</p>

                :

                <table border="1">
                    <thead>
                        <tr>
                            <th>Korisničko ime</th>
                            <th>Ime</th>
                            <th>Prezime</th>
                            <th>Pol</th>
                            <th>Datum rodjenja</th>
                            <th>Obrisi</th>
                            <th>Prikaz vezbi</th>
                            <th>Izveštaj</th>
                        </tr>
                    </thead>

                    <tbody>

                    {
                        sportisti.map((s,index)=>(

                            <tr key={index}>
                                <td>{s.korisnickoIme}</td>
                                <td>{s.ime}</td>
                                <td>{s.prezime}</td>
                                <td>{s.pol}</td>
                                <td>{s.datumRodjenja}</td>
                                <td>
                                    <button
                                        onClick={() => obrisiSportistu(s.korisnickoIme)}>
                                        Obrisi
                                    </button>
                                </td>
                                <td>
                                    <button
                                        onClick={() => prikaziVezbe(s.korisnickoIme)}
                                    >
                                        Prikaži vežbe
                                    </button>
                                </td>
                                <td>
                                    <button
                                        onClick={() => generisiIzvestaj(s.korisnickoIme)}
                                    >
                                        Generiši izveštaj
                                    </button>
                                </td>
                                
                            </tr>

                        ))
                    }

                    </tbody>
                </table>

            }

        </div>
    )
}


export default TrenerHome;