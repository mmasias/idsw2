import { interfaceConsole } from '../interface/index.js'

import { maze, colorCode } from '../data/index.js'

import { exit, moveUp, moveDown, moveLeft, moveRight, changeAvatar } from '../actions/index.js'

import { surfaceModel, colorsSurfaceModel, blockedSurface } from '../models/surfaces.js'
import { playerModel } from '../models/players.js'

import { options } from '../config/default.js'
import { allowPassage } from './../helpers/allow-passage.js'

async function start() {
    for (const position_y in maze) {
        const rows = maze[position_y]
        for (const position_x in rows) {
            const column = rows[position_x]
            if (position_y === options.position_y_player && position_x === options.position_x_player) {
                process.stdout.write(colorCode['red'])
                process.stdout.write(`${playerModel[options.avatar]}`)
            } else {
                process.stdout.write(colorCode[colorsSurfaceModel[column]])
                process.stdout.write(`${surfaceModel[column]}`)
            }
        }
        console.log('')
    }

    console.log('\x1b[33m%s\x1b[0m', 'Boat[b] Walker[n] Horse[h]')
    console.log('\x1b[36m%s\x1b[0m', 'Move: [a] [s] [d] [w]  Exit[q]')

    interfaceConsole.question('> ', input => {
        const resultAllowPassage = allowPassage({ input, maze, options, blockedSurface })

        if (!resultAllowPassage) {
            input.toUpperCase() === 'W' && moveUp({ options })
            input.toUpperCase() === 'S' && moveDown({ options, maze })
            input.toUpperCase() === 'A' && moveLeft({ options })
            input.toUpperCase() === 'D' && moveRight({ options, maze })
            input.toUpperCase() === 'Q' && exit({ options })
        }

        input.toUpperCase() === 'B' && changeAvatar({ options, avatar: 'boat' })
        input.toUpperCase() === 'N' && changeAvatar({ options, avatar: 'walker' })
        input.toUpperCase() === 'H' && changeAvatar({ options, avatar: 'horse' })

        start()
    })

    options.exit && interfaceConsole.close()
}

export default start
