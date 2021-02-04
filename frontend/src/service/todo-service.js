import axios from 'axios';

export const getTodos = () =>
    axios.get('/api/todo').then((response) => response.data);

export const createTodo = (description) =>
    axios
        .post('/api/todo', { description, status: 'OPEN' })
        .then((response) => response.data);

export const removeTodo = (id) => axios.delete('/api/todo/' + id);

export const updateTodo = (todo) =>
    axios.put('/api/todo/' + todo.id, todo).then((response) => response.data);

