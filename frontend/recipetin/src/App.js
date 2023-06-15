import './App.css';
import Footer from './components/Footer';
import BasicHeader from './components/headers/BasicHeader';
import Home from './pages/Home';
import Profile from './pages/Profile';
import Start from './pages/Start';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';


function App() {
  return (
    <div className="App">
      <BasicHeader/>
      <Router>
        <Routes>
          <Route path ='/' element={<Home/>} />
          <Route path= '/home' element={<Profile/>} />
          <Route path = '/create' element={<Start/>}/>
        </Routes>
      </Router>
      <Footer/>
    </div>
  );
}

export default App;
