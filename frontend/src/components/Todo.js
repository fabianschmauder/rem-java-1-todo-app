import React from 'react';
import styled from 'styled-components';
import {useHistory} from 'react-router-dom';

export default function Todo({ id, status, description, onAdvance, showButtons=true }) {

    const history = useHistory()

    return (
        <StyledTodo>
            <h3>
                {description} <small>[{status}]</small>
            </h3>
            {showButtons && <ButtonGroup>
                {status !== 'DONE' && (
                    <button
                        onClick={() => onAdvance({id, description, status})}
                    >
                        Advance
                    </button>
                )}
                <button onClick={() => history.push(`/delete/${id}`)}>Delete</button>
            </ButtonGroup>}
        </StyledTodo>
    );
}

const StyledTodo = styled.section`
    padding: 8px;
    border: 1px solid salmon;
    border-radius: 8px;
`;

const ButtonGroup = styled.section`
    display: flex;
    justify-content: space-between;
`;
