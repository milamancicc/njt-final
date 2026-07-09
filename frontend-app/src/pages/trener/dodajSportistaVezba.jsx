import {useState} from "react";
import {useNavigate,useParams} from "react-router-dom";
import TrenerMeni from "../../components/TrenerMeni";


function DodajSportistaVezba(){

    const {id} = useParams();
    const navigate = useNavigate();


    const [vezba,setVezba] = useState({
        sportistaId:id,
        vezbaId:"",
        brojPonavljanja:0
    });



    function handleChange(e){

        setVezba({
            ...vezba,
            [e.target.name]:e.target.value
        });

    }



    function handleSubmit(e){

        e.preventDefault();


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

                alert("Vežba dodata");

                navigate(`/sportista-vezbe/${id}`);

            }
            else{

                alert("Greška");

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

                <input
                    type="text"
                    name="vezbaId"
                    value={vezba.vezbaId}
                    onChange={handleChange}
                />


                <label>
                    Broj ponavljanja:
                </label>

                <input
                    type="number"
                    name="brojPonavljanja"
                    value={vezba.brojPonavljanja}
                    onChange={handleChange}
                />


                <button>
                    Sačuvaj
                </button>


            </form>

        </div>
    );

}

export default DodajSportistaVezba;