import Rotas from "rotas/Rotas"
import "./App.css"
import "bootstrap/dist/css/bootstrap.css"
import "bootstrap/dist/js/bootstrap.js"
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

export default function App() {
    
    return (
        <div>
            <Rotas/>
            <ToastContainer theme = 'colored'/>
        </div>

    )
}