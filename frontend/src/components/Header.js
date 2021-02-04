import React from "react";
import styled from 'styled-components';
import AddTodo from "./AddTodo";
import Search from "./Search";

export default function Header({create, search, onSearch}) {
    return <StyledHeader>
        <h1>Super Kanban Board </h1>
        <AddTodo onAdd={create}/>
        <Search search={search} onChange={onSearch}/>
    </StyledHeader>
}

const StyledHeader = styled.header`
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: center;
  
  h1 {
    color: hotpink;
  }
`