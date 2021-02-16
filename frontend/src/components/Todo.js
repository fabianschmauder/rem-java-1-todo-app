import styled from 'styled-components/macro'
import Button from './Button'

export default function Todo({ todo, onDelete, onAdvance }) {
  return (
    <Wrapper>
      <Description>{todo.description}</Description>
      <Button onClick={() => onDelete(todo)}>Delete</Button>
      {onAdvance && (
        <Button primary onClick={() => onAdvance(todo)}>
          Advance
        </Button>
      )}
    </Wrapper>
  )
}

const Wrapper = styled.section`
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-gap: 8px;
`

const Description = styled.span`
  grid-column: span 2;
  font-weight: 600;
`
