@size = $stdin.readline.to_i
@magic = $stdin.read.split(?\n).map(&:split).map! do |line|
    line.map!(&:to_i)
end

def slant(x)
    array = []
    h = @size-1
    for i in 0..@size-1 do
        if x == 0 then
            array << @magic[i][i]
        elsif x == @size-1 then
            array << @magic[h][i]
        end
        h -= 1
    end
    return array
end

def sum
    for i in 0..@size-1 do
        w = @magic[i]
        if !w.include?(0) then
          return w.inject(:+)
        end
        h = @magic.transpose[i]
        if !h.include?(0) then
            return h.inject(:+)
        end
    end
    ls = slant(0)
    if !ls.include?(0) then
        return ls.inject(:+)
    end
    rs = slant(@size-1)
    if !rs.include?(0) then
        return rs.inject(:+)
    end
end

sum = sum()
skipped = false
loop do
    b = false
    for i1 in 0..@magic.length-1 do
        for i2 in 0..@magic[i1].length-1 do
            if @magic[i1][i2] == 0 then
                n = -1
                if @magic[i1].count(0) <= 1 then
                    n = sum - @magic[i1].inject(:+)
                else
                    h = @magic.transpose[i2]
                    if h.count(0) <= 1 then
                        n = sum - h.inject(:+)
                    end
                end
                if n >= 0 then
                    @magic[i1][i2] = n
                    if !b then
                        skipped = true
                    end
                else
                    b = true
                    skipped = true
                end
            end
        end
    end
    break skipped
end
@magic.each do |line|
    puts line.join(" ")
end
