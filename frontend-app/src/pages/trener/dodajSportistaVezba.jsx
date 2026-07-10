import {useNavigate,useParams} from "react-router-dom";
import {useState, useEffect} from "react";
import TrenerMeni from "../../components/TrenerMeni";


function DodajSportistaVezba(){

    const {id} = useParams();
    const navigate = useNavigate();
    const [sveVezbe, setSveVezbe] = useState([]);

    const [vezba,setVezba] = useState({
        sportistaId:id,
        vezbaId:"",
        brojPonavljanja:0
    });

    useEffect(()=>{

        fetch("http://localhost:8080/Projekat/api/vezbe")
        .then(response => response.json())
        .then(data => {
            setSveVezbe(data);
        });

    },[]);


    function handleChange(e){

        setVezba({
            ...vezba,
            [e.target.name]:e.target.value
        });

    }



    function handleSubmit(e){

        e.preventDefault();

        console.log(vezba);
        fetch(
            "http://localhost:8080/Projekat/api/sportista-vezbe",
            {
                method:"POST",
                headers:{
                    "Content-Type":"application/json"
                },
                body:JSON.stringify(vezba)
            }
        )
        .then(response=>{

            if(response.ok){


                navigate(`/sportista-vezbe/${id}`);

            }
            else{

                alert("Greška, sportista vec ima podatke za datu vezbu. Oni se mogu samo izmeniti.");

            }

        });


    }


    return(
        <div>
            <TrenerMeni />

            <h1>
                Dodaj vežbu sportisti {id}
            </h1>


            <form onSubmit={handleSubmit}>


                <label>
                    Vežba:
                </label>

                <select
                    name="vezbaId"
                    value={vezba.vezbaId}
                    onChange={handleChange}
                >
                    <option value="">Izaberi vezbu</option>
                    {
                        sveVezbe.map(v => (
                            <option 
                                key={v.naziv}
                                value={v.naziv}
                            >
                                {v.naziv}
                            </option>
                        ))
                    }
                </select>


                <label>
                    Broj ponavljanja:
                </label>

                <input
                    type="number"
                    name="brojPonavljanja"
                    value={vezba.brojPonavljanja}
                    min={0}
                    onChange={handleChange}
                />


                <button>
                    Sačuvaj
                </button>


            </form>
            <button onClick={() => navigate(`/sportista-vezbe/${id}`)}>Povratak na sportistu {id}</button>
        </div>
    );

}

export default DodajSportistaVezba;