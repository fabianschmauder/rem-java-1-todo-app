import styled from 'styled-components/macro'
import Button from './Button'

export default function AddNewTodo() {
  return (
    <Wrapper>
      <input type="text" />
      <Button primary>Add</Button>
    </Wrapper>
  )
}

const Wrapper = styled.form`
  padding: 16px;
  display: grid;
  grid-template-columns: 1fr auto;
  grid-gap: 8px;
`
