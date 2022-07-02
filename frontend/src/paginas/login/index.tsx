import "./style.css"
import { faUserCircle } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Modal } from 'react-bootstrap';
import { useState } from "react";
import { ErrorMessage, Field, Form, Formik, FormikValues } from "formik";
import * as Yup from 'yup';
import Cadastrar from "componentes/cadastrar";

export default function Login() {
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const handleSubmit = (values: FormikValues) => {
    }

    const validations = Yup.object().shape({
        email: Yup.string().email().required(),
        password: Yup.string().min(6).required()
    });

    return (
        <div>
            <Formik initialValues={{}}
                onSubmit={handleSubmit}
                validationSchema={validations}>
                <Form>
                    <div className="loginBox">
                        <FontAwesomeIcon className="user"
                            icon={faUserCircle}
                            style={{ fontSize: 100, color: "orange" }}
                        />
                        <h3>Seja Bem-Vindo</h3>
                        <form>
                            <div className="inputBox">
                                <input id="uname" type="text" name="Username" placeholder="CPF" />

                                <div className='login-caixa'>
                                    <Field type='password'
                                        name='password'
                                        id='password'
                                        placeholder='Digite sua Senha'
                                    />
                                    <div>
                                        <ErrorMessage component='span' name='password' />
                                    </div>
                                </div>
                            </div>

                            <input type="submit" name="" value="Login" />

                        </form>
                        <button type="button" className="btnPersonal"
                            onClick={handleShow}>
                            Cadastra-se
                        </button>
                    </div>
                </Form>
            </Formik>

            <Modal
                show={show}
                onHide={handleClose}
                backdrop="static"
                keyboard={false}>
                <Modal.Header>
                    <Modal.Title></Modal.Title>
                    <button type="button"
                        className="close btnPersonal"
                        onClick={handleClose}
                        aria-label="Close">
                        Cancelar
                    </button>
                </Modal.Header>
                <Modal.Body>
                    <Cadastrar />
                </Modal.Body>
            </Modal>

        </div>
    )
}