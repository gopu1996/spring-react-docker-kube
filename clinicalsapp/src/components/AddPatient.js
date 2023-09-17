import axios from 'axios'
import React from 'react'
import './AddPatient.css'
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { Navigate } from 'react-router-dom';



class AddPatient extends React.Component {

    state = {
        navigate: false
    }



    handleSubmit(event) {
        event.preventDefault();

        const data = {
            firstName: this.firstName,
            lastName: this.lastName,
            age: this.age
        }

        axios.post('http://localhost:8080/api/addPatient', data).then(res => {
            toast.success('Patient Added Sucessfully !', {
                position: toast.POSITION.TOP_RIGHT
            });
            setTimeout(() => this.setState({ navigate: true }), 5000);
        }).catch(err => {
            console.log(err)
        })
    }

    render() {

        if (this.state.navigate) {
            return <Navigate to="/" replace />;
        }

        return (<div>

            <h2>Add Patient</h2>
            <p>Add Patient Details Here</p>
            <div className="container">
                <form >
                    <div className="row">
                        <div className="col-25">
                            <label >First Name :</label>
                        </div>
                        <div className="col-75">
                            <input type="text" id="fname" name="firstName" placeholder="Your name.." onChange={(e => this.firstName = e.target.value)} />
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-25">
                            <label >Last Name :</label>
                        </div>
                        <div className="col-75">
                            <input type="text" id="lname" name="lastName" placeholder="Your last name.." onChange={(e => this.lastName = e.target.value)} />
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-25">
                            <label>Age :</label>
                        </div>
                        <div className="col-75">
                            <input type="text" id="Age" name="age" placeholder="Your Age.." onChange={(e => this.age = e.target.value)} />
                        </div>
                    </div>
                    <br />
                    <div>
                        <button className='button' onClick={this.handleSubmit.bind(this)}  > confirm</button>
                    </div>
                </form>
            </div>
            <ToastContainer />
        </div>
        )
    }
}
export default AddPatient;

