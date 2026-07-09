import { useNavigate } from "react-router-dom";

function TrenerMeni(){

    const navigate = useNavigate();

    function logout(){
        localStorage.removeItem("trener");
        navigate("/trener-login");
    }


    return(
        <nav>
            <button onClick={() => navigate("/trener-home")}>
                Home
            </button>
            <button onClick={() => navigate("/dodaj-sportistu")}>
                Dodaj sportistu
            </button>
            <button onClick={logout}>
                Logout
            </button>
        </nav>
    );
}

export default TrenerMeni;