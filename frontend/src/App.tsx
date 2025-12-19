import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [textInput, setInput] = useState("")
  const [load, setLoad] = useState(false)
  const [refinedText, setRefinedText] = useState("")

  const Refine = async() => {
    const url = 'http://localhost:8080/api/refine';
    try {
      setLoad(true);
      const response = await fetch(url, {method: "POST", headers: {"Content-Type": "application/json"}, body: textInput});
      if (response.ok) {
      const data = await response.json();
      console.log(data);
      const cleanedText = data.polishedText.replace(/^"|"$/g, "")
      setRefinedText(cleanedText);
      }
      else {
        setRefinedText("Something went wrong, please try again")
      }
    }
    catch (error){
      console.log(error);
    } finally {
      setLoad(false);
    }
  }

  return (
    <div>
    <div className='displayWindow'>
      {refinedText}
    </div>
    <textarea value={textInput} onChange={(e) => setInput(e.target.value)}
    placeholder='Enter Your Sentence'
    rows={3}
    style={{width: "90%", height: "100%"}}/>
    <button type='button' onClick={Refine} disabled={load}>{load? "Refining...":"Refine"}</button>
    </div>
  )
}

export default App
