import React from "react";
import styled from "styled-components";
import Todo from "./Todo";
import useDeleteConfirmation from "../hooks/useDeleteConfirmation";

export default function DeleteConfirmation({todos, onDelete}){

   const [todo, handleOk, handleCancel] = useDeleteConfirmation(todos, onDelete)

    return <section>
        <p>Are you sure, you want to delete this todo?</p>
        <Todo {...todo} showButtons={false}/>
        <ButtonGroup>
            <button onClick={handleCancel}>No</button>
            <button onClick={handleOk}>Yes</button>
        </ButtonGroup>
    </section>
}

const ButtonGroup = styled.div`
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 24px;
  padding: 12px 0;
`