import React from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom';
import RowCreator from './RowCreator';
import'./Home.css'

class Home extends React.Component {


    state = {
        patientData: [],
        total_pages: 1,
        pageNumber:0,
        lastPage: false
    }



    getData = (pageno) => {
        axios.get(`http://localhost:8080/api/patients?page=${pageno}`).then(
            res => {
                const patientData = res.data.patients;
                this.setState({
                    patientData,
                    total_pages: res.data.totalPages,
                    pageNumber:res.data.pageNumber,
                    lastPage:res.data.lastPage
                })
            })
    }

    componentDidMount() {
        this.getData(0)
    }

    prevHandler = () =>{
        if(this.state.pageNumber !== 0){
            this.getData(this.state.pageNumber-1)
        }
    }

    nextPageHandler = () =>{
        if(this.state.pageNumber !== (this.state.total_pages-1)){
            this.getData(this.state.pageNumber + 1)
        }
    }

    render() {

    
         
        return (
            <React.Fragment>
                <div>
                    <h2>Patient Details</h2>
                    <table className='table'>
                        <thead>
                            <tr>
                                <th scope="col">id</th>
                                <th scope="col">FirstName</th>
                                <th scope="col">LastName</th>
                                <th scope="col">Age</th>
                                <th scope="col">Link</th>
                                <th scope="col">Link</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.patientData.map(e => <RowCreator iteam={e} key={e.id} />)}
                        </tbody>
                    </table>
                    <br></br>
                    <Link to={'/addPatient'} >
                    <button className='button'>Register Patient</button></Link>
                   
                    </div>
                    <div className="pagination">
                    <button className='button' data-testid="page-button" key={`page-button`} onClick={() => this.prevHandler()}>prev</button>

                    {
                        [...Array(this.state.total_pages)]
                            .fill()
                            .map((value, index) => {
                                return <div> 
                                    
                                         <button data-testid="page-button" className='button' key={`page-button-${index + 1}`} onClick={() => this.getData(index)}>{index + 1}</button>
                                       </div>
                            })
                    }

                     <button data-testid="page-button"  className='button' key={`page-button`} onClick={() => this.nextPageHandler()}>next</button>

                    </div>
               
            </React.Fragment>
        )



    }
}
export default Home;

