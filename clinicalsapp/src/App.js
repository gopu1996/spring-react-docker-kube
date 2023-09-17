
import './App.css';
import {Routes,Route} from 'react-router-dom'
import Home from './components/Home';
import CollectClinicals from './components/CollectClinicals';
import AddPatient from './components/AddPatient';
import AnalyzeData from './components/AnalysData';
import ChartGenerator from './components/ChartGenerator';

function App() {  
  return (
    <div className="App">
     <Routes>
          <Route exact path='/' element={ <Home />} />
          <Route exact path='/patientDetails/:patientId' element={ <CollectClinicals />} />
          <Route exact path='/addPatient' element={ <AddPatient />} />
          <Route exact path='/analyze/:patientId' element={ <AnalyzeData />} />
          <Route exact path='/chart/:componentName/:patientId' element={ <ChartGenerator />} />
     </Routes>
    </div>
  );
}

export default App;
