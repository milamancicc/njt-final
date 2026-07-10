import { useState } from "react";
import { useNavigate } from "react-router-dom";
import TrenerMeni from "../../components/TrenerMeni";
function DodajSportistu(){

    const navigate = useNavigate();
    const trener = JSON.parse(
        localStorage.getItem("trener")
    );

    const [sportista, setSportista] = useState({
        korisnickoIme:"",
        sifra:"",
        ime:"",
        prezime:"",
        pol:"M",
        datumRodjenja:"",
        trenerId: trener.korisnickoIme
    });

    function handleChange(e){

        setSportista({
            ...sportista,
            [e.target.name]: e.target.value
        });

    }


    function handleSubmit(e){

        e.preventDefault();
        
         fetch(
            "http://localhost:8080/Projekat/api/sportisti",
            {
                method:"POST",

                headers:{
                    "Content-Type":"application/json"
                },

                body: JSON.stringify(sportista)
            }
        )
        .then(response => {

            if(response.ok){

                navigate("/trener-home");

            }
            else{

                alert("Greška prilikom dodavanja sportiste");

            }

        });


    }

    return(
        <div>
            <TrenerMeni />
            <h1>Dodaj sportistu</h1>

            <form onSubmit={handleSubmit}>

                <label>Korisničko ime:</label>
                <input
                    type="text"
                    name="korisnickoIme"
                    value={sportista.korisnickoIme}
                    onChange={handleChange}
                    required
                />


                <label>Šifra:</label>
                <input
                    type="password"
                    name="sifra"
                    value={sportista.sifra}
                    onChange={handleChange}
                    required
                />


                <label>Ime:</label>
                <input
                    type="text"
                    name="ime"
                    value={sportista.ime}
                    onChange={handleChange}
                    required
                />


                <label>Prezime:</label>
                <input
                    type="text"
                    name="prezime"
                    value={sportista.prezime}
                    onChange={handleChange}
                    required
                />


                <label>Pol:</label>
                <select
                    name="pol"
                    value={sportista.pol}
                    onChange={handleChange}
                >
                    <option value="M">Muški</option>
                    <option value="Z">Ženski</option>
                </select>


                <label>Datum rođenja:</label>
                <input
                    type="date"
                    name="datumRodjenja"
                    value={sportista.datumRodjenja}
                    placeholder="dd-MM-yyyy"
                    onChange={handleChange}
                    required
                />


                <button type="submit">
                    Sačuvaj
                </button>

            </form>
        </div>
    );
}

export default DodajSportistu;