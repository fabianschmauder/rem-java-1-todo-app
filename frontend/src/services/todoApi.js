import axios from 'axios'

export const getTodos = () =>
  axios.get('api/todo').then((response) => response.data)
