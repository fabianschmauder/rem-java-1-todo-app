import React from "react";

export default function Search({search, onChange}){
    return <label>
        <input type={"search"} value={search} onChange={event => onChange(event.target.value)}/>
        <span role="img" aria-label="search"> 🔎</span>
    </label>
}