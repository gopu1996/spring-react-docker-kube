
import React from 'react'
import {Link} from 'react-router-dom'

class RowCreator extends React.Component {
  
  render() {
  var patient = this.props.iteam;

    return <tr>
        <td >{patient.id}</td>
        <td>{patient.firstName}</td>
        <td>{patient.lastName}</td>
        <td>{patient.age}</td>
        <td><Link to = {'/patientDetails/'+patient.id} >Add Data </Link></td>
        <td><Link to = {'/analyze/'+patient.id} >Analyze Data </Link></td>

    </tr>
  }
}
export default  RowCreator