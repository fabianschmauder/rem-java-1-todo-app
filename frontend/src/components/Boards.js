import styled from 'styled-components/macro'
import Board from './Board'

export default function Boards({ todos }) {
  const open = todos.filter((todo) => todo.status === 'OPEN')
  const inProgress = todos.filter((todo) => todo.status === 'IN_PROGRESS')
  const done = todos.filter((todo) => todo.status === 'DONE')

  return (
    <Wrapper>
      <Board title="Todo" todos={open} />
      <Board title="Doing" todos={inProgress} />
      <Board title="Done" todos={done} />
    </Wrapper>
  )
}

const Wrapper = styled.main`
  overflow-y: scroll;
  padding: 0 16px;
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  grid-gap: 20px;
`
