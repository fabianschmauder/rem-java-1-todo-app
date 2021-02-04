import {useEffect, useState} from "react";

export default function useSearch(todos){
    const [search,setSearch] = useState("")
    const [filteredTodos, setFilteredTodos] = useState([])

    useEffect(() => {
        setFilteredTodos(todos.filter(todo => todo.description.includes(search)))
    }, [todos, search])

    return [search, setSearch, filteredTodos]
}