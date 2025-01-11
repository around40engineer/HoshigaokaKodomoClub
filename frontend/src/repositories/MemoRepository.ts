import axios from 'axios';


export const saveMemo = async (memo: string) => {
    axios.post('/api/save', {memo: memo})
}

export const getMemos = async () => {
    const {data} = await axios.get('/api/memos')
    return data
}