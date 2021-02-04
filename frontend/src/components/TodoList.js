import React from 'react';
import Todo from './Todo';
import styled from 'styled-components';
import {useParams} from 'react-router-dom';
import {slugToStatus} from "../service/status-service";


export default function TodoList({ todos, onAdvance }) {
    const status = slugToStatus(useParams().status)
    const filteredTodos = todos.filter((todo) => todo.status === status);
    return (
        <StyledList>
            {filteredTodos.map((todo) => (
                <li key={todo.id}>
                    <Todo {...todo} onAdvance={onAdvance} />
                </li>
            ))}
        </StyledList>
    );
}

const StyledList = styled.ul`
    overflow: scroll;
    list-style: none;
    padding: 0;

    li + li {
        margin-top: 12px;
    }
`;
