import { useState } from "react";
import { useNavigate } from "react-router-dom";

function SportistaLogin(){
    const navigate = useNavigate();
    const [korisnickoIme, setKorisnickoIme] = useState("");
    const [sifra, setSifra] = useState("");
    
    function handleKorisnickoIme(e){
        setKorisnickoIme(e.target.value);
    }

    function handleSifra(e){
        setSifra(e.target.value);
    }

    async function handleSubmit(e){
        e.preventDefault();
        const response = await fetch("http://localhost:8080/Projekat/api/sportisti/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                korisnickoIme: korisnickoIme,
                sifra: sifra
            })
        });
        const text = await response.text();
        if(text === ""){
            alert("Pogresno korisnicko ime ili sifra");
        }
        else{
            const data = JSON.parse(text);
            localStorage.setItem(
                "token",
                data.token
            );
            localStorage.setItem(
                "sportista",
                JSON.stringify(data.korisnik)
            );
            navigate("/sportista-home");
        }
    }

    return(
        <div>
            <h1>Login za sportiste</h1>
            <form onSubmit={handleSubmit}>
                <label>Korisnicko ime:</label>
                <input type="text" value={korisnickoIme} onChange={handleKorisnickoIme} required></input>
                <label>Sifra:</label>
                <input type="password" value={sifra} onChange={handleSifra} required></input>
                <input type="submit" value="Log in"/>
            </form>
            <button onClick={()=>navigate("/")}>Vrati se na pocetnu stranicu</button>
        </div>
    )
}

export default SportistaLogin;