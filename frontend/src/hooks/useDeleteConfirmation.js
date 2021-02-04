import {useHistory, useParams} from "react-router-dom";

export default function useDeleteConfirmation(todos,onDelete){
    const history = useHistory()

    const {id} = useParams()
    const todo = todos.find(todo => todo.id === id)

    const handleCancel = () => history.goBack()

    const handleOk = () => {
        onDelete(id)
        history.goBack()
    }

    return [todo, handleOk, handleCancel]
}