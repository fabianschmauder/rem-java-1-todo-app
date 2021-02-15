import styled from 'styled-components/macro'
import Button from './Button'

export default function Todo({ todo }) {
  return (
    <Wrapper>
      <Description>{todo.description}</Description>
      <Button>Delete</Button>
      <Button primary>Advance</Button>
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
