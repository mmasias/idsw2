const type = {
    0: '   ',
    1: '   ',
    2: '   ',
    3: '   ',
    4: '   ',
    5: '   ',
    6: '   ',
}

const color = {
    0: 'green',
    1: 'white',
    2: 'white',
    3: 'white',
    4: 'white',
    5: 'white',
    6: 'white',
    '[#]': 'orange',
    '(*)': 'red',
    '(+)': 'purple',
    '[0]': 'white',
    '[*]': 'blue',
    '[+]': 'blue',
    '   ': 'white',
    '_0_': 'cyan',
}

const colorCode = {
    black: '\u001b[30m',
    red: '\u001b[31m',
    green: '\u001b[32m',
    orange: '\u001b[33m',
    blue: '\u001b[34m',
    purple: '\u001b[35m',
    cyan: '\u001b[36m',
    white: '\u001b[37m',
    reset: '\u001b[39m',
}

let surface = []

const getRandomArbitrary = (min, max) => {
    return parseInt(Math.random() * (max - min) + min, 10)
}

const setSurfaceDimension = async (x, y) => {
    for (let indexY = 0; indexY < y; indexY++) {
        let surfaceX = []
        for (let indexX = 0; indexX < x; indexX++) {
            surfaceX.push(getRandomArbitrary(0, 6))
        }
        surface.push(surfaceX)
    }
}

const getSurface = () => {
    return surface
}

export { type, color, colorCode, surface, setSurfaceDimension, getSurface }
