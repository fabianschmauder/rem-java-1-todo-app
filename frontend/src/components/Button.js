import styled, { css } from 'styled-components'

export default styled.button`
  border: 1px solid var(--accent);
  border-radius: 4px;
  padding: 4px;
  background: none;
  color: var(--accent);

  &:hover {
    box-shadow: 2px 2px 4px #666;
  }

  &:active {
    box-shadow: 1px 1px 4px #666;
  }

  ${(props) =>
    props.primary &&
    css`
      background: var(--accent);
      color: white;
    `}

  &:disabled {
    cursor: default;
    border-color: #666;
    background: #666;
    color: white;
    box-shadow: none;
  }
`
