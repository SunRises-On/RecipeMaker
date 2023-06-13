import './App.css';
import Footer from './components/Footer';
import BasicHeader from './components/headers/BasicHeader';
import Home from './pages/Home';
function App() {
  return (
    <div className="App">
      <BasicHeader/>
      <Home/>
      <Footer/>
    </div>
  );
}

export default App;
