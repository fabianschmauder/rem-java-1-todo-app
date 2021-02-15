import AddNewTodo from './components/AddNewTodo'
import AppHeader from './components/AppHeader'
import Boards from './components/Boards'
import PageLayout from './components/PageLayout'

export default function App() {
  return (
    <PageLayout>
      <AppHeader />
      <Boards />
      <AddNewTodo />
    </PageLayout>
  )
}
