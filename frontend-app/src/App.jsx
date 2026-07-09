import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import SportistaLogin from "./pages/sportista-login";
import TrenerLogin from "./pages/trener-login";
import SportistaHome from "./pages/sportista/sportista-home";
import TrenerHome from "./pages/trener/trener-home"
import DodajSportistu from "./pages/trener/dodaj-sportistu";
import SportistaVezbe from "./pages/trener/sportistaVezbe";
import DodajSportistaVezba from "./pages/trener/dodajSportistaVezba";

// import { useState } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from './assets/vite.svg'
// import heroImg from './assets/hero.png'
import './App.css'

function App() {
  

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/sportista-login" element={<SportistaLogin/>}/>
        <Route path="/trener-login" element={<TrenerLogin/>}/>
        <Route path="/sportista" element={<SportistaHome/>}/>
        <Route path="/trener-home" element={<TrenerHome/>}/>
        <Route path="/dodaj-sportistu" element={<DodajSportistu />}/>
        <Route path="/sportista-vezbe/:id" element={<SportistaVezbe/>}/>
        <Route path="/dodaj-sportista-vezba/:id" element={<DodajSportistaVezba/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App
