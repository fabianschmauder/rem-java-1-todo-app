import React from "react";
import styled from 'styled-components';
import {NavLink} from 'react-router-dom';

export default function Navigation(){
    return <StyledNav>
        <NavLink to="/board/open">OPEN</NavLink>
        <NavLink to="/board/in-progress">IN PROGRESS</NavLink>
        <NavLink to="/board/done">DONE</NavLink>
    </StyledNav>
}

const StyledNav = styled.nav`
  display: grid;
  grid-template-columns: repeat(3,1fr);
  justify-items: center;
  padding: 8px;
  
  a {
    text-decoration: none;
    color: hotpink;
  }
  
  a.active {
    color: deeppink;
  }
`