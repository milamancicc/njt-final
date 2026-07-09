import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {useNavigate} from "react-router-dom";
import TrenerMeni from "../../components/TrenerMeni";


function SportistaVezbe(){

    const {id} = useParams();

    const navigate = useNavigate();

    const [vezbe,setVezbe] = useState([]);


    const [izmena, setIzmena] = useState(false);
    const [izabranaVezba, setIzabranaVezba] = useState(null);
    const [noviBroj, setNoviBroj] = useState("");


    useEffect(()=>{

        fetch(
            `http://localhost:8080/Projekat/api/sportista-vezbe/${id}`
        )
        .then(response=>response.json())
        .then(data=>{
            setVezbe(data);
        });


    },[]);


    function otvoriIzmenu(v){

        setIzabranaVezba(v);

        setNoviBroj(v.brojPonavljanja);

        setIzmena(true);

    }

    function sacuvajIzmenu(){


        fetch(
            `http://localhost:8080/Projekat/api/sportista-vezbe/${id}/${izabranaVezba.vezbaId}`,
            {
                method:"PUT",
                headers:{
                    "Content-Type":"application/json"
                },
                body:JSON.stringify({
                    brojPonavljanja: noviBroj
                })
            }
        )
        .then(response=>{

            if(response.ok){

                alert("Izmenjeno");

                window.location.reload();

            }

        });

    }

    function obrisiVezbu(vezbaId){

        fetch(
            `http://localhost:8080/Projekat/api/sportista-vezbe/${id}/${vezbaId}`,
            {
                method:"DELETE"
            }
        )
        .then(response=>{

            if(response.ok){

                alert("Vežba obrisana");

                window.location.reload();

                setVezbe(
                    vezbe.filter(
                        v => v.naziv !== vezbaId
                    )
                );

            }

        });

    }

    return(

        <div>
            <TrenerMeni />

            <h1>
                Vežbe sportiste {id}
            </h1>


            {
                vezbe.length===0 ?

                <p>Nema dodeljenih vežbi</p>

                :

                <table border="1">

                    <thead>

                        <tr>
                            <th>Naziv vežbe</th>
                            <th>Norma</th>
                            <th>Ponavljanja</th>
                            <th>Obrisi</th>
                            <th>Izmeni</th>
                        </tr>

                    </thead>


                    <tbody>

                    {
                        vezbe.map((v,index)=>(

                            <tr key={index}>

                                <td>{v.vezbaId}</td>

                                <td>{v.norma}</td>

                                <td>{v.brojPonavljanja}</td>

                                <td>
                                    <button
                                        onClick={() => obrisiVezbu(v.vezbaId)}
                                    >
                                        Obrisi
                                    </button>
                                </td>

                                <td>

                                <button
                                    onClick={()=>otvoriIzmenu(v)}
                                >
                                    Izmeni
                                </button>

                                </td>

                            </tr>

                        ))
                    }

                    </tbody>

                </table>
                
            }

            <button onClick={() => navigate(`/dodaj-sportista-vezba/${id}`)}>
                Dodaj vežbu
            </button>

            {
            izmena &&

            <div style={{
                position:"fixed",
                top:"30%",
                left:"40%",
                background:"white",
                border:"1px solid black",
                padding:"20px"
            }}>

            <h3>
            Izmeni broj ponavljanja
            </h3>


            <input
            type="number"
            value={noviBroj}
            onChange={(e)=>setNoviBroj(e.target.value)}
            />


            <br/>


            <button onClick={sacuvajIzmenu}>
                Sačuvaj
            </button>


            <button
            onClick={()=>setIzmena(false)}
            >
                Otkaži
            </button>


            </div>

            }
        </div>

    );


}


export default SportistaVezbe;