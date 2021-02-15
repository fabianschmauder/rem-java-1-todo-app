import { useEffect, useState } from 'react'
import AddNewTodo from './components/AddNewTodo'
import AppHeader from './components/AppHeader'
import Boards from './components/Boards'
import PageLayout from './components/PageLayout'
import * as todoApi from './services/todoApi'

export default function App() {
  const [todos, setTodos] = useState([])

  useEffect(() => {
    todoApi.getTodos().then((loadedTodos) => setTodos(loadedTodos))
  }, [])

  const addTodo = (description) => {
    const newTodoDto = { description, status: 'OPEN' }
    todoApi.postTodo(newTodoDto).then((newTodo) => {
      const updatedTodos = [...todos, newTodo]
      setTodos(updatedTodos)
    })
  }

  const deleteTodo = (todoToDelete) => {
    todoApi.deleteTodo(todoToDelete).then(() => {
      const updatedTodos = todos.filter((todo) => todo.id !== todoToDelete.id)
      setTodos(updatedTodos)
    })
  }

  return (
    <PageLayout>
      <AppHeader />
      <Boards todos={todos} onDelete={deleteTodo} />
      <AddNewTodo onAdd={addTodo} />
    </PageLayout>
  )
}
