import { useEffect, useState } from 'react'
import AddNewTodo from './components/AddNewTodo'
import AppHeader from './components/AppHeader'
import Boards from './components/Boards'
import PageLayout from './components/PageLayout'
import * as todoApi from './services/todoApi'

export default function App() {
  const [todos, setTodos] = useState([])

  useEffect(() => {
    todoApi.getTodos().then(setTodos)
  }, [])

  return (
    <PageLayout>
      <AppHeader />
      <Boards todos={todos} />
      <AddNewTodo />
    </PageLayout>
  )
}
