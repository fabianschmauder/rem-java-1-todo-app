export const slugToStatus = slug => slug.toUpperCase().replace('-','_')

export const nextStatus = ({status}) => status === 'OPEN' ? 'IN_PROGRESS' : 'DONE';