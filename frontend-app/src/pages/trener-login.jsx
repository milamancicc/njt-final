import { useState } from "react";
import {useNavigate} from "react-router-dom";

function TrenerLogin(){
    const [korisnickoIme, setKorisnickoIme] = useState("");
    const [sifra, setSifra] = useState("");
    const navigate = useNavigate();
    
    function handleKorisnickoIme(e){
        setKorisnickoIme(e.target.value);
    }

    function handleSifra(e){
        setSifra(e.target.value);
    }

    function handleSubmit(e){
        e.preventDefault();
        fetch("http://localhost:8080/Projekat/api/treneri/login",
        {
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify({
                korisnickoIme,
                sifra
            })
        })
        .then(response=>response.json())
        .then(data=>{

            if(data==null){
                alert("Pogresno korisnicko ime ili sifra");
            }
            else{

                localStorage.setItem(
                    "trener",
                    JSON.stringify(data)
                );

                navigate("/trener-home");
            }

        });

    }

    return(
        <div>
            <h1>Login za trenere</h1>
            <form onSubmit={handleSubmit}>
                <label>Korisnicko ime:</label>
                <input type="text" value={korisnickoIme} onChange={handleKorisnickoIme}></input>
                <label>Sifra:</label>
                <input type="password" value={sifra} onChange={handleSifra}></input>
                <input type="submit" value="Log in"/>
            </form>
        </div>
    )
}

export default TrenerLogin;