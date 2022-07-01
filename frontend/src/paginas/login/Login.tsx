import "./Login.css"
import { faUserCircle } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Modal } from 'react-bootstrap';
import { useState } from "react";

export default function Login() {
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    return (
    
        <div className="loginBox">
            <FontAwesomeIcon className="user"
                icon={faUserCircle}
                style={{ fontSize: 100, color: "orange" }}
            />
            <h3>Seja Bem-Vindo</h3>
            <form>
                <div className="inputBox">
                    <input id="uname" type="text" name="Username" placeholder="CPF" />
                    <input id="pass" type="password" name="Password" placeholder="Senha" />
                </div>
                <input type="submit" name="" value="Login" />

            </form>
            <button type="button" className="btnPersonal"
                onClick={handleShow}>
                Cadastra-se
            </button> 

            <Modal
                show={show}
                onHide={handleClose}
                backdrop="static"
                keyboard={false}>
                <Modal.Header>
                    <Modal.Title></Modal.Title>
                    <button type="button"
                        className="close btn btn-secondary"
                        onClick={handleClose}
                        aria-label="Close">
                        Cancelar
                    </button>
                </Modal.Header>
                <Modal.Body>

                </Modal.Body>
            </Modal>

        </div>
    )
}