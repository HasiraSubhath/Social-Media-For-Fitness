import "./App.css";
import HomePage from "./components/Home/HomePage";
import Auth from "./components/auth/Auth";
import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <div className="">
      <Routes>
        <Route path="/*" element={true ? <HomePage /> : <Auth />}></Route>
      </Routes>
    </div>
  );
}

export default App;
