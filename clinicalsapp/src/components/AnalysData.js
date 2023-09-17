import axios from 'axios';
import React from 'react'
import TableCreator from './TableCreator';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

class AnalysData extends React.Component {

    state = {
        clinicalDatas: [],
    }

    componentDidMount() {
        axios.get('http://localhost:8080/api/patient/analyze/' + window.location.href.split('/')[4]).then(
            res => {
                this.setState(res.data)
            }
        )
    }

    render() {
        if (this.state.clinicalDatas.length === 0) {
            toast.success('No Record Found For This User !', {
                position: toast.POSITION.TOP_RIGHT
            });
        }

        return (<div>
            <h2>Patient Details:</h2>
            <p>Welcome Mr {this.state.firstName} {this.state.lastName}. Your age is {this.state.age} </p>
            <h2>Clinical Data</h2>
            {this.state.clinicalDatas.map(e => <TableCreator iteam={e} patientId={this.state.id} />)}
            <ToastContainer />
        </div>
        )
    }
}
export default AnalysData;

