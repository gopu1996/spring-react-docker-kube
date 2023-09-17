import axios from 'axios';
import React from 'react'
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { Navigate } from 'react-router-dom';

class CollectClinicals extends React.Component {

    state = {
        navigate: false
    }

    componentDidMount() {

        axios.get('http://localhost:8080/api/patient/' + window.location.href.split('/')[4]).then(
            res => {
                this.setState(res.data)
            }
        )
    }
    handleSubmit(event){
        event.preventDefault();
        const data={
            patientId:window.location.href.split('/')[4],
            componentName: this.componentName,
            componentValue:this.componentValue
        }

        axios.post('http://localhost:8080/api/addClinicalData',data).then(res=>{
            toast.success('Details Added Sucessfully !', {
                position: toast.POSITION.TOP_RIGHT
            });
            setTimeout(() => this.setState({ navigate: true }), 5000);
        })
    }


    render() {

        if (this.state.navigate) {
            return <Navigate to="/" replace />;
        }


        return (
            <div className="container">
                <h2>Patient Details:</h2>
                <p>Welcome Mr {this.state.firstName} {this.state.lastName}. Your age is {this.state.age} </p>
                <h2>Patient Clinical Data</h2>


                <form action="#">

                <label for="country">Clinical Entry Type</label>
                    <select id="country" name="country" onChange={(event)=> {this.componentName=event.target.value}}>
                        <option>Select One</option>
                        <option value="bp">Blood Pressure(Sys/Dys)</option>
                        <option value="hw">Height/Weight</option>
                        <option value="heartRate">Heart Rate</option>
                    </select>
                    <div class="form-group">
                        <label for="fname">value:</label>
                        <input type="text" class="form-control"  name="componentValue" onChange={(event)=> {this.componentValue=event.target.value}}  />
                    </div>
                   <br />
                    <button onClick={this.handleSubmit.bind(this)}  class="btn bg-success">
                        Confirm
                    </button>
                </form>
                <ToastContainer />
            </div>
        )
    }
}
export default CollectClinicals;

