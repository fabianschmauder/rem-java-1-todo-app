import axios from 'axios'

export const getTodos = () =>
  axios.get('api/todo').then((response) => response.data)

export const postTodo = (newTodoDto) =>
  axios.post('api/todo', newTodoDto).then((response) => response.data)

export const deleteTodo = (todo) => axios.delete('api/todo/' + todo.id)
