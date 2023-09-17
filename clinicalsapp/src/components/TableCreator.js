
import React from 'react'


class TableCreator extends React.Component {

   

    render() {
        var eachEntry = this.props.iteam;
        var patientId = this.props.patientId;

    
        return (
            <div className='container'>
                <table className='table'>
                    <thead>
                        <tr>
                            {eachEntry.componentName}
                        </tr>
                        <tr>
                            <td>ID: {patientId}</td>
                            <td>ComponentName : {eachEntry.componentName}</td>
                            <td>ComponentValue : {eachEntry.componentValue}</td>
                            <td>DateTime : {eachEntry.measureDateTime}</td>
                        </tr>
                    </thead>
                
                </table>
            </div>
        )
    }
}

export default TableCreator