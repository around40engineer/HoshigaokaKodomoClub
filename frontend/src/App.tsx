import {useEffect, useRef, useState} from 'react';
import './App.css'
import {getMemos, saveMemo} from './repositories/MemoRepository.ts';

export const App = () => {
    const inputRef = useRef<HTMLInputElement>(null)
    const [memos, setMemos] = useState<string[]>([])

    useEffect(()=>{
        getMemos().then((res)=>{
            setMemos(res.memos)})
    }, [])

    return (
        <>
            <h1>memo app example</h1>
            <div className="input">
                <input ref={inputRef} type='text' placeholder='メモを入力'/>
                <button onClick={async ()=>{
                    if(inputRef.current){
                        await saveMemo(inputRef.current.value)
                        setMemos([...memos, inputRef.current.value])
                        inputRef.current.value = ''
                    }
                }}>save</button>
            </div>
            <div className="display">
                <ul>
                    {memos.map((memo, index)=>{
                        return <li key={index}>{memo}</li>
                    })}
                </ul>
            </div>
        </>
    )
}

export default App
