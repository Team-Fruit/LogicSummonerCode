
size = undefined
magic = []

getArraySum = (array) ->
  sum = 0
  array.forEach (element) ->
    sum += element
    return
  sum

isNotComplete = (element, index, array) ->
  element == 0

getWidth = (y) ->
  magic[y]

getHeight = (x) ->
  array = []
  i = 0
  while i < size
    array.push magic[i][x]
    i++
  array

getSlant = (x) ->
  array = []
  h = size - 1
  i = 0
  while i < size
    if x == 0
      array.push magic[i][i]
    else if x == size - 1
      array.push magic[h][i]
    h--
    i++
  array

getSum = ->
  i = 0
  while i < size
    w = getWidth(i)
    if !w.some(isNotComplete)
      return getArraySum(w)
    h = getHeight(i)
    if !h.some(isNotComplete)
      return getArraySum(h)
    i++
  ls = getSlant(0)
  if !ls.some(isNotComplete)
    return getArraySum(ls)
  rs = getSlant(size - 1)
  if !rs.some(isNotComplete)
    return getArraySum(rs)
  return

getZeroCount = (array) ->
  c = 0
  array.forEach (element) ->
    if element == 0
      c++
    return
  c

fill = (sum, index1, index2) ->
  if getZeroCount(magic[index1]) <= 1
    return sum - getArraySum(magic[index1])
  h = getHeight(index2)
  if getZeroCount(h) <= 1
    return sum - getArraySum(h)
  return

fix = ->
  sum = getSum()
  skipped = false
  loop
    b = false
    index1 = 0
    while index1 < magic.length
      index2 = 0
      while index2 < magic[index1].length
        if magic[index1][index2] == 0
          num = fill(sum, index1, index2)
          if num != undefined
            magic[index1][index2] = num
            if !b
              skipped = false
          else
            b = true
            skipped = true
        index2++
      index1++
    unless skipped
      break
  return

putLine = (line) ->
  array = []
  line.split(' ').forEach (element) ->
    array.push +element
    return
  magic.push array
  return

reset = ->
  size = undefined
  magic = []
  return

(->
  process.stdin.resume()
  process.stdin.setEncoding 'utf8'
  process.stdin.on 'data', (chunk) ->
    array = chunk.toString().split('\n')
    size = +array[0]
    i = 1
    while i < array.length - 1
      putLine array[i]
      i++
    fix()
    magic.forEach (element) ->
      console.log element.join(' ')
      return
    reset()
    return
  return
)()
