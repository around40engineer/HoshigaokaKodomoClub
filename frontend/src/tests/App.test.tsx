import {render, screen} from '@testing-library/react';
import {describe, expect, it} from 'vitest';
import App from '../App.tsx';
import {getMemos, saveMemo} from '../repositories/MemoRepository.ts';
import {userEvent} from '@testing-library/user-event';

vi.mock('../repositories/MemoRepository.ts')

describe('App', () => {
    afterEach(() => {
        vi.mocked(saveMemo).mockClear()
        vi.mocked(getMemos).mockClear()
    })
    it('レンダーされたら各種要素が表示される', async() => {
        vi.mocked(getMemos).mockResolvedValue([])
        render(<App />)

        expect(await screen.findByRole('heading',{name:'memo app example'})).toBeInTheDocument()
        expect(await screen.findByPlaceholderText('メモを入力')).toBeInTheDocument()
        expect(await screen.findByRole('button',{name:'save'})).toBeInTheDocument()
    })
    it('レンダーされたらgetMemosを呼び、返り値を表示する', async () => {
        vi.mocked(getMemos).mockResolvedValue(['test1','test2'])
        render(<App />)

        expect(getMemos).toHaveBeenCalled()
        expect(await screen.findByText('test1')).toBeInTheDocument()
        expect(await screen.findByText('test2')).toBeInTheDocument()
    })
    it('メモを入力してsaveボタンを押したら、saveMemoを呼ぶ', async () => {
        vi.mocked(getMemos).mockResolvedValue([])
        render(<App />)

        await userEvent.type(screen.getByRole('textbox'), 'hogehoge')
        await userEvent.click(screen.getByRole('button', {name: 'save'}))

        expect(saveMemo).toHaveBeenCalledWith('hogehoge')
    })
    it('メモを入力してsaveボタンを押したら、getMemoを呼び、返り値を表示する', async () => {
        vi.mocked(getMemos)
            .mockResolvedValueOnce([])
            .mockResolvedValueOnce(['test1'])

        render(<App />)

        await userEvent.type(screen.getByRole('textbox'), 'hogehoge')
        await userEvent.click(screen.getByRole('button', {name: 'save'}))

        expect(getMemos).toHaveBeenCalledTimes(2)
        expect(await screen.findByText('test1')).toBeInTheDocument()
    })
})
