import readline from 'readline'

const interfaceConsole = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
})

export { interfaceConsole }
