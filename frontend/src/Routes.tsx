import Dashboard from "pages/Dashboard";
import Home from "pages/Home";
import { BrowserRouter, Route, Routes } from 'react-router-dom'

function Rotas() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home />} />
            </Routes>
            <Routes>
                <Route path="/dashboard" element={<Dashboard />} />
            </Routes>
        </BrowserRouter>

    );
}

export default Rotas;